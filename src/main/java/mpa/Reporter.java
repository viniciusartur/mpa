package mpa;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

import java.util.List;
import java.util.Map;

import mpa.model.Adjustment;
import mpa.model.Sale;

public class Reporter {

	public void reportSales(List<Sale> sales) {
		System.out.println("\n\nSales report\n");
		
		Map<String, Integer> map = sales.stream().collect(groupingBy(Sale::getProduct, summingInt(Sale::getValue)));
		map.forEach((product, total) -> System.out.println(product + ": " + total));
	}

	public void reportAdjusments(List<Adjustment> adjustments) {
		System.out.println("\n\nAdjusments report\n");
		
		Map<String, List<Adjustment>> map = adjustments.stream().collect(groupingBy(Adjustment::getProduct));
		for (String product : map.keySet()) {
			System.out.println(product + ": ");
			map.get(product)
				.forEach(adj -> System.out.println(" > " + adj.getOperation() + ": " + adj.getValue() + "p"));
		}
	}

}
