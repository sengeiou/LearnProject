public class Test{
	public static void main(String[] args){
		
		// AnnotationSubClass 继承了 AnnotationSuperClass

		boolean result = AnnotationSubClass.class.
		isAnnotationPresent(InheritedAnnotation.class);
		// 尝试去掉 InheritedAnnotation 的 @Inherited ，此处的 result 就是 false 了

		System.out.println("AnnotationSubClass= "+result); // true


		boolean result1 = AnnotationSuperClass.class.
		isAnnotationPresent(InheritedAnnotation.class);

		System.out.println("AnnotationSuperClass= "+result1);// true

	}
}