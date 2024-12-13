package com.mkyong.examples.Chapter10.VariantB;

import java.io.*;

class BouquetConnector {
    public void serializeBouquet(Bouquet bouquet, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(bouquet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bouquet deserializeBouquet(String filename) {
        Bouquet bouquet = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            bouquet = (Bouquet) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bouquet;
    }
}
