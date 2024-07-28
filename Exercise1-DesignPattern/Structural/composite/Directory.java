import java.util.ArrayList;
import java.util.List;

class Directory implements FileSystemItem {
    private String name;
    private List<FileSystemItem> items;

    public Directory(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void addItem(FileSystemItem item) {
        items.add(item);
    }

    public void removeItem(FileSystemItem item) {
        items.remove(item);
    }

    @Override
    public void print() {
        System.out.println("Directory: " + name);
        for (FileSystemItem item : items) {
            item.print();
        }
    }

    @Override
    public int getSize() {
        return items.stream().mapToInt(FileSystemItem::getSize).sum();
    }
}
