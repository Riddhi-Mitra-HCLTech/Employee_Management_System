//import logo from './logo.svg';
import { Route, Routes } from 'react-router-dom';
import './App.css';
import Header from './pages/header/Header';
import Dashboard from './pages/dashboard/Dashboard';
import NoMatch from './pages/noMatch/NoMatch';
import RegisterEmployee from './pages/employee/RegisterEmployee';
import UpdateEmployee from './pages/employee/UpdateEmployee';


function App() {
  return (
    <>
      <Header/>
      <Routes>
        <Route path='/' element={<Dashboard/>} />
        <Route path='/register/employee' element={<RegisterEmployee/>} />
        <Route path='/update/employee/:employeeId' element={<UpdateEmployee/>} />
        <Route path='*' element={<NoMatch/>} />
      </Routes>
    </>
  );
}

export default App;
