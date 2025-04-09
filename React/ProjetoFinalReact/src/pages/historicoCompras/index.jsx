import React, { useState, useEffect } from 'react';
import axios from 'axios';
import {
  Container,
  HistoryContainer,
  Title,
  OrderCard,
  OrderDate,
  OrderTotal,
  EmptyMessage,
} from './styles';

export const Historico = () => {
  const [orders, setOrders] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    axios.get('http://localhost:5000/compras')
      .then(response => {
        setOrders(response.data);
        setLoading(false);
      })
      .catch(error => console.error(error));
  }, []);

  return (
    <Container>
      <HistoryContainer>
        <Title>Histórico de Compras</Title>
        {loading ? (
          <p>Loading...</p>
        ) : orders.length === 0 ? (
          <EmptyMessage>Você ainda não realizou compras.</EmptyMessage>
        ) : (
          orders.map(order => (
            <OrderCard key={order.id}>
              <OrderDate>Data: {order.date}</OrderDate>
              <OrderTotal>Total: ${order.total.toFixed(2)}</OrderTotal>
            </OrderCard>
          ))
        )}
      </HistoryContainer>
    </Container>
  );
};
