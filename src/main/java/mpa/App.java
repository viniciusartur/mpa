package mpa;

import java.util.ArrayList;
import java.util.List;

import mpa.model.Adjustment;
import mpa.model.Item;
import mpa.model.Sale;

public class App {

	private List<Sale> sales = new ArrayList<Sale>();
	private List<Adjustment> adjustments = new ArrayList<Adjustment>();

	private MsgProcessor mp = new MsgProcessor();
	private Reporter reporter = new Reporter();

	public void processMsgs(List<String> msgs) {
		int count = 1;
		for (String msg : msgs) {
			Item item = mp.processMsg(msg);
			if (item instanceof Sale) {
				sales.add((Sale) item);
			} else if (item instanceof Adjustment) {
				Adjustment adj = (Adjustment) item;
				sales.stream().filter(sale -> adj.getProduct().equals(sale.getProduct()))
				.forEach(sale -> sale.makeAdjustment(adj));
				adjustments.add(adj);
			}
			if (count == 50) {
				reporter.reportAdjusments(adjustments);
				break;
			} else if (count % 10 == 0) {
				reporter.reportSales(sales);
			}
			count++;
		}
	}
}