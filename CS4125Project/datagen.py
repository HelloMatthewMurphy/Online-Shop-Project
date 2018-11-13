import os
import shutil

fileInfo = {
	"purchaseinfo.csv":
	"""Name,Quantity,Discount,Date
yeezy,2,1.00,21/11/2017,Brian
yeezy,-1,1.00,21/11/2017,Brian
yeezy,2,1.00,21/11/2017,Matt
apple,1,1.00,23/11/2017,Brian
Frog,60,1.00,23/11/2017,kys
Frog,2,1.00,23/11/2017,kys
Frog,-2,1.00,23/11/2017,kys
Sweet,2,1.00,23/11/2017,kys
Frog,1,1.00,25/10/2018,a
apple,5,1.00,25/10/2018,a
apple,12,1.00,8/11/2018,a
apple,10,1.00,8/11/2018,a
apple,2,1.00,8/11/2018,a
apple,1,1.00,8/11/2018,a
apple,10,1.00,8/11/2018,a
Sweet,1,1.00,8/11/2018,a
Sweet,1,1.00,8/11/2018,a
Sweet,-20,1.00,8/11/2018,a
""",

	"RegisteredUsers.csv":
	"""Username,Password,Email

Archie,hannah10,archbold@yahoo.ie,S
shane,passw0rd,shane.omalley2@gmail.com,C
sfdgsdfg,sfdgsfdg,sfdgsf,C
BrianArchie,dixie1,brianarchbold96@yahaoo.ie,C
kys,kys,kys,C
pass,som,som@som.com,C
som,somm,som,C
JJColins,dixie1,PogCham69@yahoo.ie,C
banana,banana,banana,S
Brian,hannah10,brianarch@yahoo.ie,C
a,a,a,C
b,b,b,S
""",

	"stockiteminfo.csv":
	"""Name,Price,Category,Description,Discount,
yeezy,68.59,clothes,a cool shoe,0.70
apple,0.49,food,a healthy snack,1.00
Frog,4.20,animal,a cute frog,1.00
Sweet,1.99,food,a delicious treat,1.00
""",

	"warehouseinfo.csv":
	"""Location,Item name,Quantity
one,apple,1000
 ,Frog,41
 ,Sweet,13
two,yeezy,50
""",
}

if __name__ == '__main__':
	# Write to csv files, creating them if they don't exist
	for filename, data in fileInfo.items():
		with open(filename, "w") as f:
			f.write(data)

	# Delete backups folder
	try:
		shutil.rmtree("backups")
	except OSError:
		print("file deletion failed")
	else:
		print("file deletion succeded")

	# Recreate the backups
	try:
		os.mkdir("backups")
	except OSError:
		print("directory creation failed")
	else:
		print("directory creation succeeded")
