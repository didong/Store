package cn.edu.imut.configurations;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Role;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.AbstractTransactionManagementConfiguration;
import org.springframework.transaction.interceptor.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix="spring.transaction.config")
public class TransactionConfigurtaion extends AbstractTransactionManagementConfiguration{

	@Value("${spring.transaction.config.pointcut}")
	private String transactionPointcut;

	private Map<String, String> method;
	public Map<String, String> getMethod() {
		return method;
	}
	public void setMethod(Map<String, String> method) {
		this.method = method;
	}
	@Bean
	@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
	public Advisor advisor(TransactionInterceptor transactionInterceptor){
		AspectJExpressionPointcutAdvisor advisor =  new AspectJExpressionPointcutAdvisor();
		advisor.setAdvice(transactionInterceptor);
		advisor.setExpression(transactionPointcut);
		return advisor;
	}

	@Bean
	@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
	public TransactionInterceptor transcationInterceptor(PlatformTransactionManager transactionManagerPrimary){
		TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
		transactionInterceptor.setTransactionManager(transactionManagerPrimary);
		transactionInterceptor.setTransactionAttributeSource(transactionAttributeSource());
		return transactionInterceptor;
	}
	
	@Bean
	@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
	public TransactionAttributeSource transactionAttributeSource(){
		NameMatchTransactionAttributeSource  methodMap = new NameMatchTransactionAttributeSource();
		Map<String,TransactionAttribute> map = new HashMap<String,TransactionAttribute>();
		for (Map.Entry<String, String> entry : method.entrySet()) {
			String[] propagation = entry.getValue().split(",");
			RuleBasedTransactionAttribute ruleBasedTransactionAttribute = new RuleBasedTransactionAttribute();
			ruleBasedTransactionAttribute.setPropagationBehaviorName(propagation[0]);  //传播行为不能为空
			if(propagation.length>1 && "true".equals(propagation[1])){
				ruleBasedTransactionAttribute.setReadOnly(true);
			}
			map.put(entry.getKey(), ruleBasedTransactionAttribute);
		}
		methodMap.setNameMap(map);
		return  methodMap;
	}

}
