package cs544.onlineforumproject.aspects;

import cs544.onlineforumproject.util.IMailMail;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ForumAspect {

    private IMailMail emailSender;

    public void setEmailSender(IMailMail emailSender) {
        this.emailSender = emailSender;
    }

    @Around("execution(public String cs544.onlineforumproject.controller.UserController.addUser(String,String,String,String))")
    public void registrationConfirmaion(ProceedingJoinPoint joinpoint) throws Throwable {
        Object[] objects = joinpoint.getArgs();
        String name = (String) objects[0];
        String email = (String) objects[2];
        joinpoint.proceed();

        //Send registration confirmation for user
        emailSender.sendMail("ea2bookshopping@gmail.com", email, "Registration success",
                "Dear " + name + " You have successfully registered with A2W onlin forum");

    }
}
