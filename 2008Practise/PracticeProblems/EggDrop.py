
def fibo(n):
    sum = 0
    while True:

def calcFPrime(D,B):
    FPrime = 0
    while True:
      if (B == 0 or D == 0):
          return FPrime
      elif(B == D):
          FPrime = FPrime + 2**(B)-1
      else:
        FPrime = FPrime + 1

    return FPrime

def trisum(n, csum):
...     while True:                     # change recursion to a while loop
...         if n == 0:
...             return csum
...         n, csum = n - 1, csum + n



def calcDPrime(F,B):
    DPrime = 0
    for i in range(0,F+1):
        FPrime = calcFPrime(i,B)
        if(FPrime >= F):
            DPrime = i
            break

    return DPrime

def calcBPrime(F,D):
    BPrime = 0
    for i in range(D,-1,-1):
        FPrime = calcFPrime(D,i)
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
    f = open ("c:\\gcj\\2008Practise\\PracticeProblems\\C-small-practice.in",'r')
    g = open ("c:\\gcj\\2008Practise\\PracticeProblems\\C-small-practice.out",'w')
    lines = f.readlines()
    nCases = int(lines[0])
    lines.pop(0)
    case = 0
    lines = [lines[3]]
    for line in lines:
        case = 0
        bla = line.split()
        F = int(bla[0])
        D = int(bla[1])
        B = int(bla[2])
        FPrime = calcFPrime(D,B)
        DPrime = calcDPrime(F,B)
        BPrime = calcBPrime(F,D)
        g.write("Case #" + str(case) + ": " + str(FPrime) + " " + str(DPrime) + " " + str(BPrime))


# F D B (floors, drops, broken)
# algorithm for F': if D = B: F' = 2**B-1
# otherwise: F' = D*(D-1)/2(geometric sum)+ 1 + F'((D-1),B)

# for D': go from D = B and calulate F' until it is lager or equal to F
# for B': go from B = D and go down until F' is below F. Then take the one below.


    return 1

eggDrop()

calcFPrime(20,6)












