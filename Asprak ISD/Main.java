import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class InventoryItem {
    // Kelas ini untuk menyimpan itemnya
    private String code;
    private String itemType;
    private String name;
    private int stock;

    public InventoryItem(String code, String itemType, String name, int stock) {
        this.code = code;
        this.itemType = itemType;
        this.name = name;
        this.stock = stock;
    }

    // Method Getter dan setter
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Code: " + code + ", Type: " + itemType + ", Name: " + name + ", Stock: " + stock;
    }
}

class InventoryManager<T extends InventoryItem> {
    // Ini generic nya
    private ArrayList<T> inventory;

    public InventoryManager() {
        this.inventory = new ArrayList<>();
    }

    public void addItem(T item) {
        inventory.add(item);
    }

    public void removeItem(String code) {
        inventory.removeIf(item -> item.getCode().equals(code)); // remove data yang cocok dengan kode item
    }

    public void editItem(String code, T newItem) {
        for (int i = 0; i < inventory.size(); i++) { // for loop untuk iterasi per data
            if (inventory.get(i).getCode().equals(code)) { // inventory.get(i).getCode().equals(code)
                inventory.set(i, newItem); // Ubah i ke yang baru
                break;
            }
        }
    }

    public void displayInventory() {
        Collections.sort(inventory, Comparator.comparing(InventoryItem::getCode)); // display akan diurutkan berdasarkan kode
        for (T item : inventory) {
            System.out.println(item.toString()); // print hasil sort tadi
        }
    }
}

class ATK extends InventoryItem {
    public ATK(String code, String itemType, String name, int stock) {  // mewariskan peninggalan kelas InventoryItem
        super(code, itemType, name, stock);
    }
}

class Bag extends InventoryItem {
    public Bag(String code, String itemType, String name, int stock) { // mewariskan peninggalan kelas InventoryItem
        super(code, itemType, name, stock);
    }
}

public class Main {
    public static void main(String[] args) {
        InventoryManager<ATK> atkManager = new InventoryManager<>();
        InventoryManager<Bag> bagManager = new InventoryManager<>();

        // Menambahkan data untuk ATK
        atkManager.addItem(new ATK("A001", "Pulpen", "Snowman Board Marker", 50));
        atkManager.addItem(new ATK("A002", "Pensil", "Faber-Castell HB", 30));
        atkManager.addItem(new ATK("A003", "Spidol", "Sharpie Permanent Marker", 20));
        atkManager.addItem(new ATK("A004", "Pulpen", "Pilot G2 Gel Pen", 40));
        atkManager.addItem(new ATK("A005", "Pensil", "Mitsubishi 9800 Pencil", 25));
        atkManager.addItem(new ATK("B001", "Buku Tulis", "Oxford", 25));
        atkManager.addItem(new ATK("B002", "Buku Tulis", "front", 73));
        atkManager.addItem(new ATK("B003", "kertas HVS", "Prodigi", 9));

        // Menambahkan data untuk Bag
        bagManager.addItem(new Bag("C001", "Tempat Pensil", "Cute Pencil Case", 15));
        bagManager.addItem(new Bag("C002", "Tas", "Canvas Backpack", 10));
        bagManager.addItem(new Bag("C003", "Tempat Pensil", "Faber Castle", 18));
        bagManager.addItem(new Bag("C004", "Tas", "Laptop Sleeve", 12));
        bagManager.addItem(new Bag("C005", "Tempat Pensil", "Mesh Pencil Organizer", 20));

        // Menampilkan data
        System.out.println("Data ATK:");
        atkManager.displayInventory();

        System.out.println("\nData Tas:");
        bagManager.displayInventory();

        // Menghapus data dengan berdasarkan kode
        atkManager.removeItem("A003");
        atkManager.removeItem("A004");
        atkManager.removeItem("A005");
        atkManager.removeItem("B002");
        atkManager.removeItem("C004");
        atkManager.removeItem("C005");

        // Mengedit data
        Bag editedBag = new Bag("C002", "Tas", "Stylish Backpack", 8); // edit nama
        bagManager.editItem("C002", editedBag);

       
        Bag editedBag2 = new Bag("C003", "Pensil", "Faber Castle", 10); // edit tipe
        bagManager.editItem("C003", editedBag2);


        ATK editedAtk = new ATK("B003", "kertas HVS", "Prodigi", 777); // edit stok
        atkManager.editItem("B003", editedAtk);

        // Menampilkan data setelah perubahan
        System.out.println("\nATK setelah remove:");
        atkManager.displayInventory();

        System.out.println("\nBag setelah remove:");
        bagManager.displayInventory();
    }
}
