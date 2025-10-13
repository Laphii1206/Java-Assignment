This coursework tests your understanding of object classes, object composition, control structures and arrays.  Data structures (ArrayList, List, etc) other than array are Not allowed. 

Design and develop a simple Java program for a storage system.  A cabinet has a capacity of 1,000,000 cm3.  The cabinet can store storage boxes of various sizes.  Each storage box can store multiple items.

Your system has the following features:

•	Add storage box – this feature adds a new storage box to the cabinet.  The information needed to add a storage box includes the label of the storage box (eg: toys, Kitchen tools, gardening tools, games, sports 1, sports 2, which should be unique) and its capacity (in cm3).
  
•	Put item into a storage box – this feature adds an item to a storage box.  It prompts for the item’s information (name and size in cm3) and the storage box in which it should be placed. If the size of the item exceeds the available space in the storage box, the attempt will be canceled. A message will be displayed to inform the user of the progress of the attempt. 

•	View items in storage boxes – this feature allows user to view all the items in all the storage boxes.  Each storage box will display its label, capacity, used space, remaining space and all items (name and size) in the storage box.  The output is tabulated in rows and columns.  Labels in columns are left-aligned, and numbers in columns are right-aligned.


Class Design Requirements **

Item class - This class has attributes for the item, a constructor that can initialize item and toString method that returns the information needed to view the item information. 

Storage class - This class has private attributes for the storage box, a constructor that performs object initialization, a toString method that returns the information of a storage box.  It provides other methods for adding storage, adding items to storage box and viewing the storage box information. 
 
Main class – This class instantiates an array of storage box objects.  It provides users with a menu for the 3 main activities.  It allows the users to repeat the activities until they choose to exit the program. It also includes simple input validation. 

