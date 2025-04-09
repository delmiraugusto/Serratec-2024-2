import PropTypes from 'prop-types'

export const Item = ({ marca, anoLancamento }) => {
    return (
        <>
            <li>
                {marca} - {anoLancamento}
                </li>
        </>
    )
}

Item.propType = {
    marcar: PropTypes.string.isRequired,
    anoLancamento: PropTypes.number
}

Item.defaultProps = {
    marca: "Faltou a marca",
    anoLancamento: 0
}