int i  = input("Enter an integer")
print ("print",i)
sum=1
for x in range(len(i),0,-1):
    sum=(sum*x)
    
print(sum)  