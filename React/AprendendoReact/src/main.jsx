import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { Routers } from './routes/index'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <Routes />
  </StrictMode>,
)
