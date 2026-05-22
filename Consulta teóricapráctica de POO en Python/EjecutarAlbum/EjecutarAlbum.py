import sys, os
sys.path.insert(0, os.path.dirname(__file__))

from Jugador import Jugador
from Estampilla import Estampilla
from Pagina import Pagina
from Album import Album


if __name__ == "__main__":

    # 1. Crear jugadores
    jugador1 = Jugador("Lionel Messi",    "Delantero",    10)
    jugador2 = Jugador("Kylian Mbappé",   "Delantero",     7)
    jugador3 = Jugador("Kevin De Bruyne", "Mediocampista", 7)

    # 2. Crear estampillas
    estampilla1      = Estampilla("ARG-10", jugador1, True)
    estampilla2      = Estampilla("FRA-07", jugador2, False)
    estampilla_nueva = Estampilla("ARG-10", jugador1, True)

    # 3. Crear páginas y asignar estampillas (Composición)
    pagina1 = Pagina(1)
    pagina1.estampilla_izquierda = estampilla1

    pagina2 = Pagina(2)
    pagina2.estampilla_derecha = estampilla2

    # 4. Crear el álbum (Agregación)
    album = Album(pagina1, pagina2)

    # 5. Calcular completitud
    total_esperadas = 4
    porcentaje = album.calcular_porcentaje_completitud(total_esperadas)

    print("--- RESULTADOS DEL ÁLBUM ---")
    print(f"Porcentaje de completitud: {porcentaje}%\n")

    # 6. Verificar estampilla repetida
    repetida = album.verificar_repetida(estampilla_nueva)
    if repetida:
        print(f"Alerta: La estampilla con ID '{estampilla_nueva.id_estampilla}' ya está registrada en el álbum.")
    else:
        print("La estampilla no está repetida.")