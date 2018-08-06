package bhouse.travellist_starterproject;

import java.util.ArrayList;

public class PlaceData {

    public static String[] placeNameArray = {"Sri Ramakrishna",
            "Ashtalakshmi",
            "Kapalishwar",
            "Parthasarathy",
            "Vadapalani",
            "Kaligambaltemple",
            "Iskcon"};

    public static String[] historyArray = {"\nRamakrishna Math is a monastic organisation for men brought into existence by Ramakrishna a 19th-century saint of Bengal.",
            "\nThe Ashtalakshmi Kovil is a Hindu temple, which lies on the shorelines near the Elliot's beach, in Chennai, India. The temple is dedicated to the goddess Lakshmi, and her eight primary forms – the Ashtalakshmi – the giver of all eight forms of wealth, namely, offspring, success, prosperity, wealth, courage, bravery, food, and knowledge.",
            "\nThe commonly held view is that the temple was built in the 7th century CE by the ruling Pallavas. This view is based on references to the temple in the hymns of the Nayanmars (which, however, place it by a sea shore). The temple's 120 ft gopuram(gateway tower) was built during 1906 with stucco figures adorning it",
            "\nThe temple was originally built by the Pallavas in the 8th century, subsequently expanded by Cholas and later by the Vijayanagara kings in the 15th century. The temple was originally built by the Pallavas in the 8th century, subsequently expanded by Cholas and later by the Vijayanagara kings in the 15th century. ",
            "\nBuilt around 1890, this temple began as a simple thatched shed. Around 7,000 couples marry there each year.  During his worship, he experienced divine power entering his body and inspiring him to speak surprising things later found to be true. His utterances were labeled 'arul vakku' ('God blessed statements') and could cure diseases, provide jobs, solemnize marriages and more",
            "\nKaligambaltemple",
            "\nIskcon"};

    public static String[] descriptionArray = {"\nRamakrishna Math is a monastic organisation for men brought into existence by Ramakrishna a 19th-century saint of Bengal.",
            "\nThe Ashtalakshmi Kovil is a Hindu temple, which lies on the shorelines near the Elliot's beach, in Chennai, India. The temple is dedicated to the goddess Lakshmi, and her eight primary forms – the Ashtalakshmi – the giver of all eight forms of wealth, namely, offspring, success, prosperity, wealth, courage, bravery, food, and knowledge.",
            "\nThe Kapaleeshwarar temple is of typical Dravidian architectural style, with the gopuram overpowering the street on which the temple sits. The vahanas (Sanskrit for vehicles) at the temple include the bull, Adhikaranandi, elephant, bandicoot, peacock, goat and parrot, while a golden chariot is a recent addition.",
            "\nThe Parthasarathy Temple is an 8th-century Hindu Vaishnavite temple dedicated to the god Krishna, located at Triplicane, Chennai, India. The temple has icons of five forms of Vishnu: Narasimha, Rama, Gajendra Varadaraja, Ranganatha and Krishna.",
            "\nVadapalani Andavar Temple is a Hindu temple dedicated to Lord Muruga. It is located in Vadapalani, Chennai. It was renovated in the 1920s and a Rajagopuram was built during that time.The Vadapalani Murugan Temple has many niches like Dakshina Murti, Chandikeswar, Mahalakshmi, etc situated in the inner prakara.",
            "\nKaligambaltemple",
            "\nIskcon"};
    public static String[] timingArray = {"\nRamakrishna Math is a monastic organisation for men brought into existence by Ramakrishna a 19th-century saint of Bengal.",
            "\nThe Ashtalakshmi Kovil is a Hindu temple, which lies on the shorelines near the Elliot's beach, in Chennai, India. The temple is dedicated to the goddess Lakshmi, and her eight primary forms – the Ashtalakshmi – the giver of all eight forms of wealth, namely, offspring, success, prosperity, wealth, courage, bravery, food, and knowledge.",
            "\nThe temple rituals are performed six times a day Ushathkalam at 6:00 a.m., Kalasanthi at 9:00 a.m., Uchikalam at 1:00 p.m., Sayarakshai at 5:00 p.m., Irandamkalam at 7:00 p.m. and Ardha Jamam at 9:00 p.m.",
            "\nEvery Day 0600 HRS to 1300 HRS and 1600 HRS to 2100 HRS",
            "\nEvery Day 0600 HRS to 1300 HRS and 1600 HRS to 2100 HRS",
            "\nEvery Day 0600 HRS to 1300 HRS and 1600 HRS to 2100 HRS",
            "\nEvery Day 0600 HRS to 1300 HRS and 1600 HRS to 2100 HRS"};

    public static ArrayList<Place> placeList() {
        ArrayList<Place> list = new ArrayList<>();
        for (int i = 0; i < placeNameArray.length; i++) {
            list.add(new Place(placeNameArray[i],placeNameArray[i].replaceAll("\\s+", "").toLowerCase(),
                    descriptionArray[i],historyArray[i],timingArray[i]));
        }
        return list;
    }
}
