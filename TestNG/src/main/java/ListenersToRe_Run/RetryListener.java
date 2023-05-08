package ListenersToRe_Run;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer {

	@Override
	public void transform(final ITestAnnotation annotation, final Class testClass, final Constructor constructor, final Method testMethod) {
		annotation.setRetryAnalyzer(Retry.class);
		//annotation.getretryAnalizer();

	}

}
