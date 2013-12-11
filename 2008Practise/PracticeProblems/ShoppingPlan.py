

def shoppingPlan():
    nCases = 0
#    f = open ("c:\\gcj\\2008Practise\\PracticeProblems\\C-large-practice.in",'r')
#    g = open ("c:\\gcj\\2008Practise\\PracticeProblems\\C-large-practice.out",'w')
    f = open ("/home/andreask/gcj/2008Practise/PracticeProblems/D-small-practice.in",'r')
    g = open ("/home/andreask/gcj/2008Practise/PracticeProblems/D-small-practice.out",'w')
    lines = f.readlines()
    nCases = int(lines[0])
    l=0
    for i in range(1,2):
        l = l+1
        nItems, nStores, gasPrice = map(int,lines[l].split())
        l = l+1
        items = [x for x in lines[l].split()]
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


    return stores

"dd:4488".split(':')
map(int,["23", "56"])
shoppingPlan()



