package backend.services;

import backend.dtos.AuthRequestDTO;
import backend.dtos.AuthResponseDTO;

public interface AuthService {
    AuthResponseDTO login(AuthRequestDTO request);
}
