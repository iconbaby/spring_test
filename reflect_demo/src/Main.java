import com.slkk.PrivateCar;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class<?> clazz = loader.loadClass("com.slkk.PrivateCar");
        PrivateCar car = (PrivateCar) clazz.newInstance();

        Field color = clazz.getDeclaredField("color");
        color.setAccessible(true);
        color.set(car, "红色");

        Method drive = clazz.getDeclaredMethod("dirve", (Class[]) null);
        drive.setAccessible(true);
        drive.invoke(car, (Object[]) null);

    }
}
