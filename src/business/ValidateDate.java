package Assignment1.src.business;

public class ValidateDate {
	
	public void validateDate(String date) throws DateNotValid {
        if (!validate(date)) {
            throw new DateNotValid("Date is not valid");
        }
    }
	
	//Validation of date will show as Date is not valid if wrong format
	public static boolean validate(String date) {
		if(!date.isEmpty()) {
			String[] tokens = date.split("/");
			boolean mFlag = false;
			boolean dFlag = false;
			boolean yFlag = false;
			int month = 0;
			int date1 = 0;
			int year = 0;
			if( tokens.length == 3 ) {
				try 
		        {
					month = Integer.parseInt(tokens[0]);
					mFlag = true;
		        } 
		        catch (NumberFormatException e1) 
		        {
		        	mFlag = false;
		        }
				try 
		        {
					date1 = Integer.parseInt(tokens[1]);
					dFlag = true;
		        } 
		        catch (NumberFormatException e1) 
		        {
		        	dFlag = false;
		        }
				try 
		        {
					year = Integer.parseInt(tokens[2]);
					yFlag = true;
		        } 
		        catch (NumberFormatException e1) 
		        {
		        	yFlag = false;
		        }
				if( mFlag && dFlag && yFlag ) {
					if( (month < 13 && month > 0) && ( date1 < 32 && date1 > 0 ) && ( tokens[2].length() == 4 )) {
						return true;
					}
					else {
						return false;
					}
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}			
		}
		else {
			return false;
		}
	}

}
