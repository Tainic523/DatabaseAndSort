package annotation;

import java.lang.reflect.Field;

public class FruitUtils {
    public static void getFruitInfo(Class<?> clazz){
        StringBuilder strFruitName = new StringBuilder("水果名称");
        StringBuilder strFruitColor = new StringBuilder("水果颜色");
        StringBuilder strFruitProvider = new StringBuilder("水果提供商");

        Field [] fields = clazz.getDeclaredFields();

        for (Field f:fields){

            if (f.isAnnotationPresent(FruitName.class)){
                FruitName fruitName = f.getAnnotation(FruitName.class);
                strFruitName.append(fruitName.value());
                System.out.println(strFruitName);
            }
            if (f.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor = f.getAnnotation(FruitColor.class);
                strFruitColor.append(fruitColor.fruitColor());
                System.out.println(strFruitColor);
            }
            if (f.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider = f.getAnnotation(FruitProvider.class);
                strFruitProvider.append(fruitProvider.id()).append(fruitProvider.name()).append(fruitProvider.address());
                System.out.println(strFruitProvider);
            }

        }




    }
}
