import { BrowserRouter, Routes, Route } from "react-router-dom"
import { Login } from "../pages/Login"


export const Routers = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/login" element={<Login />}>



                </Route>
            </Routes>
        </BrowserRouter>
    )
}