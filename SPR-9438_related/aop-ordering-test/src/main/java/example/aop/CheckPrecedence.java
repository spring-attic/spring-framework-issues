package example.aop;

public interface CheckPrecedence {
	int HIGHER_PRECEDENCE = 0; // far from pointcut
	int NORMAL_PRECEDENCE = 1; 
	int LOWER_PRECEDENCE = 2; // near to pointcut
}
