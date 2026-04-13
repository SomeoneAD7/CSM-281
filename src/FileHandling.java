import java.io.*; 
// import java.io.File;

// the InputStreamReader can also be used to read user input. But it can read only 1 bit at a time. 

public class FileHandling {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\HP\\Desktop\\Darrel\\programming\\Java\\CSM 281"); 
        File dir2 = new File("C:\\Users\\HP\\Desktop\\Darrel\\programming\\Java\\CSM 281\\src");
        // File file = new File(dir, "test.txt"); 

        if (dir.exists()){
            String[] files = dir.list();
            System.out.println(files.length + " files found in directory "); 
        } 

        System.out.println(); 

        if (dir2.exists()){
            String[] files2 = dir2.list();
            System.out.println(files2.length + " files found in directory ");
        }

        /*if (file.exists()) {
            System.out.println("File already exists."); 
        } 
        else {
            try{
                file.createNewFile(); 
                System.out.println("File created successfully."); 
            } 
            catch(IOException e){
                System.out.println(e);
            }
        }*/
    }
}
