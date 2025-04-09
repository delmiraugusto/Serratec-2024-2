import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
// import { App } from './AppLogin'
import { App } from "./AppInicio"

createRoot(document.getElementById('root')).render(
  <StrictMode>
    {/* <App /> */}
    <App />

  </StrictMode>,
)
