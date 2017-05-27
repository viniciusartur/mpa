package mpa;

import static mpa.util.Constants.ADD_OPERATION;
import static mpa.util.Constants.DELIMITER;
import static mpa.util.Constants.MULTIPLY_OPERATION;
import static mpa.util.Constants.SUBTRACT_OPERATION;
import static org.apache.commons.lang3.StringUtils.chop;

import mpa.model.Adjustment;
import mpa.model.Item;
import mpa.model.Sale;

public class MsgProcessor {

	public Item processMsg(String msg) {
		Item item = null;

		if (isMessageType3(msg)) {
			item = processMessageType3(msg);
		} else if (isMessageType1(msg)) {
			item = processMessageType1(msg);
		} else if (isMessageType2(msg)) {
			item = processMessageType2(msg);
		}

		return item;
	}

	private Item processMessageType1(String msg) {
		String[] words = msg.split(DELIMITER);
		return new Sale(words[0], new Integer(chop(words[2])), 1);
	}

	private Item processMessageType2(String msg) {
		String[] words = msg.split(DELIMITER);
		return new Sale(chop(words[3]), new Integer(chop(words[5])), new Integer(words[0]));
	}

	private Item processMessageType3(String msg) {
		String[] words = msg.split(DELIMITER);
		return new Adjustment(chop(words[2]), new Integer(chop(words[1])), words[0]);
	}
	
	private boolean isMessageType1(String msg) {
		return msg.split(DELIMITER).length == 3;
	}

	private boolean isMessageType2(String msg) {
		return msg.split(DELIMITER).length == 7;
	}

	private boolean isMessageType3(String msg) {
		String firstWord = msg.split(DELIMITER)[0];
		return ADD_OPERATION.equals(firstWord) || SUBTRACT_OPERATION.equals(firstWord)
				|| MULTIPLY_OPERATION.equals(firstWord);
	}
}
