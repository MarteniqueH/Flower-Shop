package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Optional;


/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Determine if the partRepository already has any parts in it
        if(partRepository.count()>0 || productRepository.count()>0 || outsourcedPartRepository.count()>0) {
            return;
        }

        // A set to keep track of the part names that have already been used to avoid duplicate names
        Set<String> usedPartNames = new HashSet<>();

        // Creation of Outsourced Parts
        OutsourcedPart chocolateBox = new OutsourcedPart();
        chocolateBox.setName(getUniqueName("Chocolate Box", usedPartNames));
        chocolateBox.setInv(25);
        chocolateBox.setPrice(15.00);
        chocolateBox.setCompanyName("Chocolate Factory");
        chocolateBox.setMinInventory(1);
        chocolateBox.setMaxInventory(100);
        partRepository.save(chocolateBox);

        OutsourcedPart greetingCard = new OutsourcedPart();
        greetingCard.setName(getUniqueName("Greeting Card", usedPartNames));
        greetingCard.setInv(15);
        greetingCard.setPrice(5.00);
        greetingCard.setCompanyName("Cards For ALL");
        greetingCard.setMinInventory(1);
        greetingCard.setMaxInventory(100);
        partRepository.save(greetingCard);

        OutsourcedPart stuffTeddyBear = new OutsourcedPart();
        stuffTeddyBear.setName(getUniqueName("Teddy Bear",usedPartNames));
        stuffTeddyBear.setInv(25);
        stuffTeddyBear.setPrice(20.00);
        stuffTeddyBear.setCompanyName("Build a Teddy");
        stuffTeddyBear.setMinInventory(1);
        stuffTeddyBear.setMaxInventory(100);
        partRepository.save(stuffTeddyBear);

        OutsourcedPart scentedCandle = new OutsourcedPart();
        scentedCandle.setName(getUniqueName("Scented Candle",usedPartNames));
        scentedCandle.setInv(30);
        scentedCandle.setPrice(10.00);
        scentedCandle.setCompanyName("Smell the WICK");
        scentedCandle.setMinInventory(1);
        scentedCandle.setMaxInventory(100);
        partRepository.save(scentedCandle);

        OutsourcedPart giftRibbon = new OutsourcedPart();
        giftRibbon.setName(getUniqueName("Gift Ribbon", usedPartNames));
        giftRibbon.setInv(100);
        giftRibbon.setPrice(5.00);
        giftRibbon.setCompanyName("Tie The Knot");
        giftRibbon.setMinInventory(1);
        giftRibbon.setMaxInventory(100);
        partRepository.save(giftRibbon);

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }


        Product roseBouquet = new Product();
        roseBouquet.setName("Rose Bouquet");
        roseBouquet.setPrice(60.00);
        roseBouquet.setInv(100);
        productRepository.save(roseBouquet);

        Product tulips = new Product();
        tulips.setName("Tulips");
        tulips.setPrice(40.00);
        tulips.setInv(75);
        productRepository.save(tulips);

        Product hydrangeas = new Product();
        hydrangeas.setName("Hydrangeas");
        hydrangeas.setPrice(20.00);
        hydrangeas.setInv(25);
        productRepository.save(hydrangeas);

        Product lilies = new Product();
        lilies.setName("Lilies");
        lilies.setPrice(30.00);
        lilies.setInv(80);
        productRepository.save(lilies);

        Product sunflowers = new Product();
        sunflowers.setName("Sunflowers");
        sunflowers.setPrice(25.00);
        sunflowers.setInv(40);
        productRepository.save(sunflowers);


        stuffTeddyBear.getProducts().add(roseBouquet);
        scentedCandle.getProducts().add(roseBouquet);

        greetingCard.getProducts().add(tulips);
        chocolateBox.getProducts().add(tulips);

        stuffTeddyBear.getProducts().add(hydrangeas);
        giftRibbon.getProducts().add(hydrangeas);

        stuffTeddyBear.getProducts().add(lilies);
        chocolateBox.getProducts().add(lilies);

        greetingCard.getProducts().add(sunflowers);
        scentedCandle.getProducts().add(sunflowers);


        partRepository.save(chocolateBox);
        partRepository.save(greetingCard);
        partRepository.save(stuffTeddyBear);
        partRepository.save(scentedCandle);
        partRepository.save(giftRibbon);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());
    }
    // Helper method to ensure unique names
private String getUniqueName(String startingName, Set<String> usedNames) {
        String uniqueName = startingName;
        int count = 1;
// Checks if the name already exist in the set of names
        while (usedNames.contains(uniqueName)){
            uniqueName = startingName + " " + count;
            count = count + 1;

        }
        // Adds new unique name to the set
        usedNames.add(uniqueName);
        return uniqueName;



}

}




