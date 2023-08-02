package folder.auction;

import java.util.ArrayList;
import java.util.List;

public class AuctionController {

    //  DESIGN AN AUCTION MONITORING TOOL

    //  An item is up for auction. The item is created with a initial sale price.
    //  There are bidders that compete to buy the item.
    //  There are 4 events that happen in the auction.
    //  Item goes on for sale, bidder raises a bid, bidder withdraws, item is sold.
    //  The buyers can bid and raise a certain amount (random amount), or withdraw.
    // There is no constraint on the number of bidders or the order of bidding.
    // No time related constraints.
    // Generate a log for all the events in an auction.


    public static void main(String[] args) {

        //AuctionServices auctionServices = null;

        AuctionEntities auctionEntities = new AuctionEntities();
        List<Items> itemsList  = new ArrayList<>();
        List<Bidders> biddersList  = new ArrayList<>();

        Items items = new Items();
        items.setItemid(1);
        items.setItemDescription("des");
        items.setItemName("car");
        itemsList.add(items);
        Bidders bidders = new Bidders();
        bidders.setId(1);
        bidders.setName("name");
        biddersList.add(bidders);
        auctionEntities.setBidders(biddersList);
        auctionEntities.setList(itemsList);


       // auctionServices.generateLogs(EventType.ITEM, auctionEntities);





    }




}
