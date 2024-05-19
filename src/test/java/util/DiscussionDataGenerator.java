package util;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.AddDiscussionData;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DiscussionDataGenerator {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter entity count");
        int count = Integer.parseInt(in.nextLine());
        AddDiscussionData[] array = new AddDiscussionData[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Enter title");
            String title = in.nextLine();
            System.out.println("Enter description");
            String description = in.nextLine();
            AddDiscussionData data = new AddDiscussionData();
            data.title = title;
            data.description = description;
            array[i] = data;
        }
        XmlMapper mapper = new XmlMapper();
        File file = new File("src/test/java/data/discussion_data.xml");
        mapper.writeValue(file, array);
    }
}
