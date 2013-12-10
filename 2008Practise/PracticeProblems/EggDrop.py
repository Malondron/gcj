


def calcFPrime(D,B,F):
    FPrime = 0
#    print D
#    print B
#    print F
    if ((B == 0) or (D == 0)):
        return 0
    elif(D == 1):
        return 1
    else:
        return 1 + F[str([D-1,B])] + F[str([D-1,B-1])]


def calcDPrime(F,B,Fos):
    DPrime = 0
    for i in range(0,F+1):
        FPrime = calcFPrime(i,B,Fos)
        if(FPrime >= F):
            DPrime = i
            break

    return DPrime

def calcBPrime(F,D,Fos):
    BPrime = 0
    for i in range(D,-1,-1):
        FPrime = calcFPrime(D,i,Fos)
#        print FPrime
        if(FPrime < F):
            BPrime = i+1
            break

    return BPrime

def eggDrop ():
    nCases = 0
    l = 0
    x = [0,0]
    y = [0,0]
    f = open ("/home/andreask/gcj/2008Practise/PracticeProblems/C-large-practice.in",'r')
    g = open ("/home/andreask/gcj/2008Practise/PracticeProblems/C-large-practice.out",'w')
    lines = f.readlines()
    nCases = int(lines[0])
    lines.pop(0)
    case = 0
    Fos = {}


    for j in range (0,1000):
      for i in range(0,1000):
          cFP = calcFPrime(i, j, Fos)
          Fos[str([i,j])] = cFP


    for line in lines:
        case = case + 1
        bla = line.split()
        F = int(bla[0])
        D = int(bla[1])
        B = int(bla[2])
        if(B > 32):
            FPrime = -1
        else:
            FPrime = calcFPrime(D,B,Fos)

        if(FPrime > 2**32):
            FPrime = -1
        DPrime = calcDPrime(F,B,Fos)
        BPrime = calcBPrime(F,D,Fos)
        g.write("Case #" + str(case) + ": " + str(FPrime) + " " + str(DPrime) + " " + str(BPrime) + '\n')



# F D B (floors, drops, broken)
# algorithm for F': if D = B: F' = 2**B-1
# otherwise: F(D,B) = F(D-1,B-1) + 1 + F((D-1),B)

# for D': go from D = B and calulate F' until it is lager or equal to F
# for B': go from B = D and go down until F' is below F. Then take the one below.


    return 1

eggDrop()


2**32
def test ():
    t = [[i*j for i in range(0,5)] for j in range(0,4)]

    return t[3][3]

test()

for i in range(0,3):
    for j in range(0,2):

        print [i,j]









