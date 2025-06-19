interface ProductSearch {
    void search(String keyword);
}
class ElectronicsSearch implements ProductSearch {
    public void search(String keyword) {
        System.out.println("Searching Electronics for: " + keyword);
    }
}

class ClothingSearch implements ProductSearch {
    public void search(String keyword) {
        System.out.println("Searching Clothing for: " + keyword);
    }
}

class BookSearch implements ProductSearch {
    public void search(String keyword) {
        System.out.println("Searching Books for: " + keyword);
    }
}
class SearchFactory {
    public ProductSearch getSearch(String category) {
        if (category == null) return null;
        if (category.equalsIgnoreCase("ELECTRONICS")) return new ElectronicsSearch();
        if (category.equalsIgnoreCase("CLOTHING")) return new ClothingSearch();
        if (category.equalsIgnoreCase("BOOK")) return new BookSearch();
        return null;
    }
}
public class ECommerceSearchDemo {
    public static void main(String[] args) {
        SearchFactory factory = new SearchFactory();

        ProductSearch s1 = factory.getSearch("ELECTRONICS");
        s1.search("Smartphone");

        ProductSearch s2 = factory.getSearch("CLOTHING");
        s2.search("T-Shirts");

        ProductSearch s3 = factory.getSearch("BOOK");
        s3.search("Data Structures");
    }
}