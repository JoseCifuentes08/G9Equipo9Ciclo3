#**************************Listas - Agregar valor******************************************************************

#lista= ["lunes","martes","miercoles","jueves","viernes","sabado"]

#lista.append("domingo")

#print (lista)

#*****************Listas - Agregar valor en punto especifico*****************************************************

#Lista= [1,2,3,5,6]

#Lista.insert (3,4)

#print (Lista)


#******************************Listas - Confirmar elementos *****************************************************

#lista = [1,2,3,4,5,6,"David"]

#print ("David" in lista)

#*******************************Listas - Buscar indice de valor **************************************************

#lista= [2,4,6,8,10, "jose"]

#print (lista.index ("jose"))

#*******************************Listas - Contar repeticiones ****************************************************

#lista= [2,4,6,8,10, "jose" , 2 , 5 , 8,9,10, "jose",4,2,2,5,1, "jose"]

#print (lista.count(2))

#*******************************Listas - Borrar datos por indice***************************************************

#lista= [2,4,6,8,10, "jose"]

#lista.pop (3)

#print (lista)

#*********************************Listas - Borrar datos especificos **********************************************************

#lista= [2,4,6,8,10, "jose"]

#lista.remove(4)

#print(lista)

#**********************************Listas - Limpiar Lista **********************************************************

#lista= [2,4,6,8,10, "jose"]

#lista.clear()

#print(lista)

#***********************************listas - Ordenar y voltear Listas *********************************************

#Lista= [-8,-15,-25,5,8,20,47,1,3,-1]

#Lista.sort()
#Lista.reverse()

#print (Lista)

#***********************************Agrupar elementos individuales de una lista*************************************************
#theList = list(range(10))
#N = 3
#subList = [theList[n:n+N] for n in range(0, len(theList), N)]
#print(subList)

archivo = open('agenda.txt','r')
contenido= archivo.read()
palabra = contenido.splitlines()
i=0
e=0
buscarp = input("Digite la primera letra del Nombre del beneficiario a buscar:")
while i<len(palabra):
          if palabra[0].startswith(buscarp):
             e=e+1
             print(palabra[i])
             print(palabra[i+1])
             print(palabra[i+2])
             break
          i+=1
archivo.close()











