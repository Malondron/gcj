def alwaysTurnLeft ():
    nCases = 0
    l = 0
    x = [0,0]
    y = [0,0]
    f = open ("c:\\gcj\\2008Practise\\PracticeProblems\\B-large-practice.in",'r')
    g = open ("c:\\gcj\\2008Practise\\PracticeProblems\\B-large-practice.out",'w')
    lines = f.readlines()
    nCases = int(lines[0])
    types = {'[1, 0, 0, 0]' : '1', '[0, 1, 0, 0]' : '2', '[1, 1, 0, 0]' : '3', '[0, 0, 1, 0]' : '4',
             '[1, 0, 1, 0]' : '5', '[0, 1, 1, 0]' : '6', '[1, 1, 1, 0]' : '7', '[0, 0, 0, 1]' : '8',
             '[1, 0, 0, 1]' : '9', '[0, 1, 0, 1]' : 'a', '[1, 1, 0, 1]' : 'b', '[0, 0, 1, 1]' : 'c',
             '[1, 0, 1, 1]' : 'd', '[0, 1, 1, 1]' : 'e', '[1, 1, 1, 1]' : 'f'}
    lines.pop(0)
    case = 0
    for line in lines:
        case = case +1
        g.write("Case #" + str(case) + ":\n")
        cells =  getCells(line)
        sortedCells = sorted(cells, key=lambda x: (x[0][1], x[0][0]))

        row = 0
        row_text = ''
        for cell in sortedCells:
            if (cell[0][1] == row):
                cell.pop(0)
                row_text = row_text + types[str(cell)]
            else:
                cell.pop(0)
                g.write(row_text+'\n')
                row = row+1
                row_text = types[str(cell)]

        g.write(row_text+'\n')





    return 1


def stepPermute(direction,step):
    ret = direction
# direction: [0, 1] = 's', [0,-1] = 'n', [1, 0] = 'e', [-1,0] = 'w'
    if(step == 'L'):
        if (direction == [0, 1]):
            ret = [1, 0]
        elif(direction == [0,-1]):
            ret = [-1, 0]
        elif(direction == [1,0]):
            ret = [0, -1]
        else:
            ret = [0, 1]
    elif(step == 'R'):
        if (direction == [0, 1]):
            ret = [-1, 0]
        elif(direction == [0,-1]):
            ret = [1, 0]
        elif(direction == [1,0]):
            ret = [0, 1]
        else:
            ret = [0, -1]
    return ret



def getCells(walks):
    walkss = walks.split()
    cells = []
    direction = [0, -1]
    position = [0,-1]


    for walk in walkss:
        direction = map(lambda x: x * -1, direction)
#        print direction
        steps = list(walk)
        for step in steps:
            if(step == 'W'):
                position = [position[0] + direction[0], position[1] + direction[1]]
                cells = addToCell(cells,position,direction,step)
            else:
                cells = addToCell(cells,position,direction,step)
                direction = stepPermute(direction,step)

        cells.pop()


    return cells

def addToCell(cells,position,direction,step):
# cells(position, can-go-north, south, west, east)
    if (not position in [x[0] for x in cells]):
        cells.append([position,0,0,0,0])

    cell = [x for x in cells if (x[0] == position)]
    cell = cell[0]
#    print cell
#    print step
#    print position
#    print direction

    if(step == 'W'):
        if (direction == [1, 0]):
            cell[3] = 1
        elif (direction == [-1, 0]):
            cell[4] = 1
        elif (direction == [0, 1]):
            cell[1] = 1
        else:
            cell[2] = 1
#    elif (step == 'L'):
#        if (direction == [1, 0]):
#            cell[4] = 0
 #       elif (direction == [-1, 0]):
 #           cell[3] = 0
 #       elif (direction == [0, 1]):
 #           cell[2] = 0
 #       else:
 #           cell[1] = 0
 #   else:
 #       if (direction == [1, 0]):
 #           cell[1] = 0
 #           cell[4] = 0
 #       elif (direction == [-1, 0]):
 #           cell[2] = 0
 #           cell[3] = 0
 #       elif (direction == [0, 1]):
 ##           cell[4] = 0
 #           cell[2] = 0
 ##       else:
  #          cell[3] = 0
  #          cell[1] = 0
#    print cells
    return cells

alwaysTurnLeft()

def test():
    m = [[1, 0],1,0,0,1]
    m.pop(0)
    return str(m)

test()

