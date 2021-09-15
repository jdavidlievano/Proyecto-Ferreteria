<template>
    <div id="Historial" class="Historial">
        <table>
            <tr>
                <th>Fecha</th>
                <th>Hora</th>
                <th>ID</th>
                <th>UserId</th>
                <th>ProductID</th>
                <th>Movimiento</th>
                <th>Cantidad</th>
            </tr>

            <tr v-for="movement in obtainMovements" :key="movement.id">
                <td>{{ movement.dateMovement.substring(0, 10) }}</td>
                <td>{{ movement.dateMovement.substring(11, 19) }}</td>
                <td>{{ movement.id }}</td>
                <td>{{ movement.userId }}</td>
                <td>{{ movement.productId }}</td>
                <td>{{ movement.movement }}</td>
                <td>{{ movement.quantity }}</td>
            </tr>
        </table>
    </div>
</template>

<script>
import gql from 'graphql-tag'
export default {
    name: 'Movements',

    data: function(){
        return {
            obtainMovements: [],
        };
    },

    apollo: {
        obtainMovements: {
            query: gql`
                query {
                    obtainMovements{
                        id
                        userId
                        productId
                        movement
                        quantity
                        dateMovement
                    }
                }
            `,
            variables(){

            },
        },
    },
    
};
</script>

<style>
#Historial {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  margin-top: 50px;
  padding-bottom: 50px;
}

#Historial table {
  width: 50%;
  border-collapse: collapse;
  border: 1px solid rgba(0, 0, 0, 0.3);
  border-radius: 20px;
}

#Historial table td,
#Historial table th {
  border: 1px solid #ddd;
  padding: 8px;
}

#Historial table tr:nth-child(even) {
  background-color: #f2f2f2;
}

#Historial table tr:hover {
  background-color: #ddd;
}

#Historial table th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: crimson;
  color: white;
}
</style>