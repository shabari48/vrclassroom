public class FileSystemExample {
    public static void main(String[] args) {
        // Create individual files
        FileSystemItem file1 = new File("file1.txt", 10);
        FileSystemItem file2 = new File("file2.txt", 20);
        FileSystemItem file3 = new File("file3.txt", 15);

        // Create a directory and add files to it
        Directory dir1 = new Directory("dir1");
        dir1.addItem(file1);
        dir1.addItem(file2);

        // Create another directory that includes the first directory and another file
        Directory dir2 = new Directory("dir2");
        dir2.addItem(dir1);
        dir2.addItem(file3);

        // Print the structure and calculate total size for dir2
        dir2.print();
        System.out.println("Total size: " + dir2.getSize() + "KB");
    }
}
