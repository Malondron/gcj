def alwaysTurnLeft ():
    nCases = 0
    l = 0
    f = open ("C:\\gcj\\2008Practise\\PracticeProblems\\B-small-practice.in",'r')
    g = open ("C:\\gcj\\2008Practise\\PracticeProblems\\B-small-practice.out",'w')
    lines = f.readlines()
    nCases = int(lines[0])
    types = {[1, 0, 0, 0] : '1', [0, 1, 0, 0] : '2', [1, 1, 0, 0] : '3', [0, 0, 1, 0] : '4',
             [1, 0, 1, 0] : '5', [0, 1, 1, 0] : '6', [1, 1, 1, 0] : '7', [0, 0, 0, 1] : '8',
             [1, 0, 0, 1] : '9', [0, 1, 0, 1] : 'a', [1, 1, 0, 1] : 'b', [0, 0, 1, 1] : 'c',
             [1, 0, 1, 1] : 'd', [0, 1, 1, 1] : 'e', [1, 1, 1, 1] : 'f'}
    return getCells(lines[1])


def stepPermute(direction,step):
    ret = direction
    if(step == 'L'):
        if (direction == [0, 1]):
            ret = [1, 0]
        elif(direction == [0,-1]):
            ret = [-1, 0]
        elif(direction == [1,0]):
            ret = [0,-1]
        else:
            ret = [0,1]
    elif(step == 'R'):
        if (direction == [0, 1]):
            ret = [-1, 0]
        elif(direction == [0,-1]):
            ret = [1, 0]
        elif(direction == [1,0]):
            ret = [0,1]
        else:
            ret = [0,-1]
    return ret

def getCells(walks):
    walkss = walks.split()
    cells = []
    direction = [0, 1]
    position = [0,-1]

    for walk in walkss:
        steps = list(walk)
        for step in steps:
             if(step == 'W'):
                 cells.append([position,direction])
                 position = [position[0] + direction[0], position[1] + direction[1]]
                 cells.append([position,direction])
             elif(step == 'L')
                direction = stepPermute(direction,step)



