import { BrowserRouter, Routes, Route } from "react-router-dom"
import { Login } from "../pages/Login"
import { Home } from "../pages/Home"
import { PageError } from "../pages/PageError"


export const Routers = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="" element={<PageError />} />
                <Route path="*" element={<PageError />} />

                <Route path="/" element={<Home />} />
                <Route path="/login" element={<Login />} />
            </Routes>
        </BrowserRouter>
    )
}