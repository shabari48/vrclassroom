class File implements FileSystemItem {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void print() {
        System.out.println("File: " + name + " (Size: " + size + "KB)");
    }

    @Override
    public int getSize() {
        return size;
    }
}
