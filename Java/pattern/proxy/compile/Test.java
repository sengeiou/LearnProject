import javax.tools.*;
import java.io.*;
import java.util.Arrays;

public class Test{


    public static void main(String[] args) throws Exception{

        String str =
        "public class Test{"+

            "public static void main(String[] args){"+

                "System.out.println(\"Hello World\");"+

            "}"+

        "}";

        System.out.println(System.getProperty("user.dir"));

        String packagePath =  System.getProperty("user.dir") + "/com/cocoa/compile";

        File filePath  = new File(packagePath);
        File file = new File(filePath,"Test.java");

        if(!filePath.exists()){
          filePath.mkdirs();
          file.createNewFile();
        }

        FileWriter writer = new FileWriter(file);

        writer.write(str);
        writer.close();

        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        System.out.println(javac);

        StandardJavaFileManager fileManager = javac.getStandardFileManager(null, null, null);

        Iterable<? extends JavaFileObject> compilationUnits1 =
                  fileManager.getJavaFileObjects(file);
        javac.getTask(null, fileManager, null, null, null, compilationUnits1).call();

        javac.close();

    }

}
