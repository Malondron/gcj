


#end with perishable. Start from the last. If at store where have bought item, and there is another item,
#it is always preferrable to buy the other as well, compared to another store, if the price plus gas to another store is lower.
def shoppingPlan():
    nCases = 0
#    f = open ("c:\\gcj\\2008Practise\\PracticeProblems\\C-large-practice.in",'r')
#    g = open ("c:\\gcj\\2008Practise\\PracticeProblems\\C-large-practice.out",'w')
    f = open ("/home/andreask/gcj/2008Practise/PracticeProblems/D-small-practice.in",'r')
    g = open ("/home/andreask/gcj/2008Practise/PracticeProblems/D-small-practice.out",'w')
    lines = f.readlines()
    nCases = int(lines[0])
    l=0
    for i in range(2,3):
        l = l+1
        nItems, nStores, gasPrice = map(int,lines[l].split())
        l = l+1
        items = [x for x in lines[l].split()]
        perishItems = [x[0:-1] for x in items if (x[-1] == '!')]
        for per in perishItems:
            items.remove(per + '!')
        stores = []
        for j in range(0,nStores):
            store = {}
            l = l + 1
            d = lines[l].split()
            storeItems = len(d) - 2
            xCoord = int(d[0])
            yCoord = int(d[1])
            store['xCoord'] = xCoord
            store['yCoord'] = yCoord

            for k in range(0,storeItems):
                things = d[2+k].split(':')
                store[things[0]] = int(things[1])
            stores.append(store)


    return items

"dd:4488".split(':')
map(int,["23", "56"])
shoppingPlan()


[1,2,4,5].remove(1)
"hej"[-1]
import math
200+math.sqrt(18)*5+math.sqrt(7**2+9)*5+ 90 + 150+20

