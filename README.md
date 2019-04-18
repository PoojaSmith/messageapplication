# Message Processing Application
This is a small message processing single threaded application for processing sales notification messages.

It is based on the assumption that sales messages come in JSON format. The application logs the report detailing the number after every 10th message.The application only parses all notifications but processes only (first) 50 of them. In actual implementation, the json would probably be received as a response to an API call, but here it is read from commandline.

##On execution:
1) application initializes sales (read from CSV file provided as commandline argument),
2) parses sales notifications from JSON file (provided as commandline argument), and
3) updates sales register to reflect 50 sales notifications.

##Sample Commandline Arguments:
1) Inside eclipse Run As -> Run configuration set arguments to two following path and run appliccation
2) First argument is stock file: /Users/pooja.shah/samples/message-processing-app/src/resources/sales.csv
3) Second and last argument is notifications file: /Users/pooja.shah/samples/message-processing-app/src/resources/allnotifications.json

##Sample Data:
There are five sample data files:
1) sales.csv: This file has stock data listed in there. The data is listed in the order of class (Product) members.
2) notifications.json: This file only has notification messages of Message Type 1.
3) secondlevelnotifications.json: This file only has notification messages of Message Type 2.
4) adjustmentnotifications.json: This file only has notification messages of Message Type 3.
5) allnotifications.json: This file only has notification messages of all Message Types.



