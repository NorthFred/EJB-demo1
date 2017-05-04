
package textprovider;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Random;
import javax.ejb.EJB;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author frede
 */
@Stateless
@LocalBean
public class TextProviderBean {

    // Injecting tje QuoteCounter Session Bean into this Class for tracking the amounts a quote has been generated.
    @EJB
    private QuoteCounter quoteCounter;
    

    public String randomQuote() {
        
        // This list is fetched from the database...
        List<String> quotes = new ArrayList<>(Arrays.asList("You can cover a great deal of country in books.", 
            "I would rather be right and die than be wrong and kill.",
            "Life is a risk.",
            "It's easy to be wicked without knowing it, isn't it?",
            "You don't have to die in order to make a living.",
            "If you would throughly know anything, teach it to others"));
        
        Random rndgenerator = new Random();
        String str = quotes.get(rndgenerator.nextInt(quotes.size()));
        
        quoteCounter.increaseCounter();
        
        return str;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
