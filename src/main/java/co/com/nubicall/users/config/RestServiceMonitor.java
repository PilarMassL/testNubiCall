package co.com.nubicall.users.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class RestServiceMonitor {

	private static final Logger log = LoggerFactory.getLogger(RestServiceMonitor.class);

	private static ObjectMapper mapper = new ObjectMapper();

	@Around("execution(* co.com.nubicall.users.controllers.UserController.*(..))")
	public Object restLogger(ProceedingJoinPoint point) throws Throwable {

		Logger classLog = LoggerFactory.getLogger(point.getTarget().getClass());

		try {
			logParameters(point.getTarget().getClass(), point.getSignature().getName(), classLog, point.getArgs());

		} catch (Exception e) { 
			log.info("Unable to write to logs, check " + getClass(), e);
		}

		try {
			Object retVal = point.proceed();

			String responseString = mapper.writeValueAsString(retVal);
			classLog.info("USER-NUBICALL: Response " + point.getSignature().getName() + ": " + responseString);
			return retVal;

		} catch (Exception ex) {
			classLog.error("Error found: ", ex);
			throw ex;
		}
	}

	private void logParameters(Class<?> clazz, String signature, Logger classLog, Object[] args) throws Throwable {

		if (args != null && args.length > 0) {
			StringBuilder builder = new StringBuilder("");

			builder.append("USER-NUBICALL: Request Parameters " + signature + ": ");
			for (int i = 0; i < args.length; i++) {
				Object arg = args[i];
				String parameter = mapper.writeValueAsString(arg);
				builder.append(parameter);
				if (i != args.length - 1) {
					builder.append(",");
				}
			}
			classLog.info(builder.toString());
		}
	}

}
