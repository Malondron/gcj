import math

def alienNumbers():

    nCases = 0
    l = 0
    f = open ("C:\\gcj\\2008Practise\\PracticeProblems\\A-small-practice.in",'r')
    g = open ("C:\\gcj\\2008Practise\\PracticeProblems\\A-small-practice.out",'w')
    lines = f.readlines()
    nCases = int(lines[0])
    l = l + 1

    for i in range(1,nCases+1):
        g.write("Case #" + str(i) + ": " + translateNumber(lines[l].split()) + "\n")
        l = l+1

    return 1

def translateNumber(lineParts):
    number = list(lineParts[0])
    numLen = len(number)
    sourceLang = list(lineParts[1])
    targetLang = list(lineParts[2])
    newBase = len(targetLang)
    base = len(sourceLang)
    valueToTranslate = 0
    outNumb = ''
    for i in range(0,numLen):
        valueToTranslate = valueToTranslate + base**(numLen-(i+1))*sourceLang.index(number[i])
    largestExponent = math.floor(math.log(valueToTranslate)/math.log(newBase))
    for i in range(int(largestExponent),-1,-1):
        if ((newBase**(i+1) > valueToTranslate) and (newBase**(i) <= valueToTranslate)):
            for j in range(0,newBase):
                if ((j+1)*newBase**i > valueToTranslate):
                     valueToTranslate = valueToTranslate - j*newBase**i
                     outNumb = outNumb + targetLang[j]
                     break
        else:
            outNumb = outNumb + targetLang[0]

    return outNumb

6**3*2+6*3+4
alienNumbers()
6-5
"hej" + str(3)
range(3,1,-1)