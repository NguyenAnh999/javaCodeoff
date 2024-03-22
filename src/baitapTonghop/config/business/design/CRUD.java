package baitapTonghop.config.business.design;

public interface CRUD {
    void add(int choice);
    void delete(int choice);
    void upDate(int choice);

    void displayDAta(int choice);
    void sortUp(int choice);

    void sortDown(int choice);
    void searchByName(int choice);
}
