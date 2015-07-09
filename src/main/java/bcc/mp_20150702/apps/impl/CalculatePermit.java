package bcc.mp_20150702.apps.impl;

import java.text.DecimalFormat;

import org.apache.commons.lang3.StringUtils;

import bcc.mp_20150702.apps.GenericApp;

public class CalculatePermit extends GenericApp{
		
	public CalculatePermit(String usage, String example) {
		super(usage, example);
	}

	private Float standardPermitPrice = 100.0f;
	
	@Override
	public String run(String[] args) {
		if(args.length == 2){
			String postcode = args[0];
			if(StringUtils.startsWithIgnoreCase(postcode, "BS") && StringUtils.isNumeric(args[1])){
				try{
					Float total = 0f;
					String result = "";
					int quantity = Integer.parseInt(args[1]);
					int intCode = Integer.parseInt(postcode.split("((?<=[a-zA-Z])(?=[0-9]))|((?<=[0-9])(?=[a-zA-Z]))")[1]);
					if(intCode<20 && quantity<=3){
						total += standardPermitPrice * quantity;
						DecimalFormat fmt = new DecimalFormat("#.##");
						result += "\nOverall permit price: £"+fmt.format(total);
						if(intCode<4){
							int premiums = 25 * quantity;
							total += premiums;
							result += "\nPremiums: £"+fmt.format(premiums);
						}
						float discounts = ((25*standardPermitPrice)/100) * (quantity-1);
						if(discounts>0){
							total -= discounts;
							result += "\nDiscounts: £"+fmt.format(discounts);
						}
						result += "\nTotal: £"+fmt.format(total);
						result += "\n";
						return result;
					}
				}catch(Exception e){
					
				}
			}
		}
		return sendError();
	}
	
	@Override
	public String sendError() {
		return "There was an error with your request. Type 'help' to see usage.";
	}

}
