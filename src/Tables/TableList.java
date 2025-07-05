package Tables;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TableList {
    public static List<Table> tableList = new ArrayList<>();
    private static final String FILE_PATH = "src/Tables/tables.txt";

    public TableList() {
        getDataFromFile();
    }

    public void getDataFromFile() {
        tableList.clear();
        File input = new File(FILE_PATH);

        // Check if file exists AND is empty. If so, create default tables.
        if (!input.exists() || input.length() == 0) {
            for (int i = 1; i <= 5; i++) { // Example: 5 tables
                tableList.add(new Table(i, false));
            }
            dataToFile(); // Save default tables to file
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] info = line.split(" , ");
                if (info.length == 2) {
                    try {
                        int id = Integer.parseInt(info[0].trim());
                        boolean isOccupied = Boolean.parseBoolean(info[1].trim());
                        tableList.add(new Table(id, isOccupied));
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number format in tables.txt: " + info[0]);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void dataToFile() {
        try (FileWriter fw = new FileWriter(FILE_PATH)) {
            for (Table table : tableList) {
                fw.write(table.getID() + " , " + table.isOccupied() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Table getTableByID(int ID) {
        for (Table table : tableList) {
            if (table.getID() == ID) {
                return table;
            }
        }
        return null;
    }

    public void updateTableStatus(int ID, boolean isOccupied) {
        Table table = getTableByID(ID);
        if (table != null) {
            table.setOccupied(isOccupied);
            dataToFile();
        }
    }
} 