/*
V = 4
    INF = 999999


    def minimumCycleLength(graph):
    dist =  [[0]*V for i in range(V)]
    print(dist)
    for i in range(V):
    for j in range(V):
    dist[i][j] = graph[i][j];
    for k in range(V):
    for i in range(V):
    for j in range(V):
    dist[i][j] = min(dist[i][j] ,dist[i][k]+ dist[k][j])
    print(dist)
    length = INF
    # for i in range(V):
    #     for j in range(V):
    #       if(i!=j):
    #          if(dist[i][j]+dist[j][i] < length):
    #            length = dist[i][j]+dist[j][i]
    for i in range(V):
    length = min(dist[i][i],length)


    if(length == INF):
    print("No cycle")
    return length



    # graph = [ [INF, 1, INF,INF, INF],
    #         [INF, INF, 1,INF,INF],
    #         [INF, INF, INF, 1,1],
    #         [1,INF, INF, INF, INF],
    #         [INF,1, INF, INF, INF] ]


    graph = [ [INF, 4, INF,INF],
    [INF, INF, 1,INF],
    [10, INF, INF, 2],
    [2,INF, INF, INF] ]
    # graph = [ [INF, 3, INF,INF],
    #         [INF, INF, 2,INF],
    #         [INF, INF, INF, 1],
    #         [INF,INF, INF, INF] ]
    length = minimumCycleLength(graph)
    print(length)*/
