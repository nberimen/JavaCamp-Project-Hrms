import './TextInput.css'
import React from 'react'
import { useField, ErrorMessage } from 'formik'

const TextInput = ({ label, ...props }) => {

    const [field, meta] = useField(props);

    
    return (
        <div className="mb-2">
            <label htmlFor={field.name}>{label}</label>
            <input
                className={`form-control shadow-none ${meta.touched && meta.error && 'is-invalid'}`}
                {...field} {...props}
                autoComplete="off"
               
            />
            <ErrorMessage  name={field.name} className="error" />
        </div>
    )
}

export default TextInput
