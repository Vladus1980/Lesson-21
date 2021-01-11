package Ex01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class ApplicationCar {

	public static void main(String[] args) throws Exception {
		ArrayList<String> annotationList = values(Car.class);
		for (String string : annotationList) {
			System.out.println(string);
		}
		
		toFile(new File("Car.txt"), annotationList);

	}
	public static ArrayList<String> values(Class<?> annotationClass){
		
		ArrayList<String> valuesList = new ArrayList<String>();
		java.lang.reflect.Field[] fieldCar = annotationClass.getDeclaredFields();
		
		for (int i = 0; i < fieldCar.length; i++) {
			java.lang.reflect.Field field = fieldCar[i];
			
			if (field.getAnnotation(CarAnnotation.class) instanceof CarAnnotation) {
				valuesList.add(field.getType().getSimpleName() + field.getName() + ((CarAnnotation) field.getAnnotation(CarAnnotation.class)).value());
			}
		}
		 
 		return valuesList;
		
	}
	
	
	public static void toFile(File file, Object object) throws Exception{
		OutputStream os = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(object);
		oos.close();
		os.close();
	}

}
